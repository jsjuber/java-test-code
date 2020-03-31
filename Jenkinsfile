pipeline {
    agent {
        docker { image 'node:7-alpine' }
    }
    stages {
        stage('Test') {
            steps {
                sh '''
                 node --version
                 docker run -dit node:7-alpine /bin/sh
                '''
            }
        }
    }
}
