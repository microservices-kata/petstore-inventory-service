def srvName = 'inventory-service'
def gitRepo = 'https://github.com/microservices-kata/petstore-inventory-service.git'
def devUser = 'scaleworks'
def devHost = '10.202.129.46'
def registryUrl = '10.202.129.203:5000'
def gradleImage = 'gradle:3.5-jdk8-alpine'
def gradleFolder = '/opt/gradle'
node {
    stage('代码更新') {
        checkout scm: [$class: 'GitSCM', branches: [[name: '*/master']],
                      userRemoteConfigs: [[url: gitRepo]]]
    }
    docker.image("${gradleImage}").inside("-v ${gradleFolder}:/root/.gradle") {
        stage('构建代码') {
            sh 'gradle build'
        }
    //    stage('验证契约') {
    //        sh "export PACT_BROKER_URL=\"http://${devHost}:2000\"; gradle pactVerify"
    //    }
    }
    stage('创建镜像') {
        sh "mv -f build/libs/*.jar deployment/${srvName}.jar"
        sh "docker build -t ${registryUrl}/${srvName}:$BUILD_NUMBER deployment"
        sh "docker push ${registryUrl}/${srvName}:$BUILD_NUMBER"
        sh "docker rmi ${registryUrl}/${srvName}:$BUILD_NUMBER"
    }
    stage('部署Dev环境') {
        def devDockerDaemon = "tcp://${devHost}:2376"
        sh "docker -H ${devDockerDaemon} rm -f ${srvName} | true"
        sh "docker -H ${devDockerDaemon} run -d --name ${srvName} --net=host \
            ${registryUrl}/${srvName}:$BUILD_NUMBER"
        sh "docker -H ${devDockerDaemon} image prune --force --all \
            --filter until=`date -d '5 day ago' '+%F'`"
    }
}
