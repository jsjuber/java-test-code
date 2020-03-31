pipeline {
  agent {
    docker {
      args '-p 80:80'
      image ' juber786/nginx-test'
    }

  }
  stages {
    stage('check image') {
      steps {
        sh '''
docker images'''
      }
    }

    stage('Build container') {
      steps {
        sh '''

docker run -dit --name webserver -p 80:80 juber786/nginx-test:latest /bin/bash
'''
      }
    }

  }
}