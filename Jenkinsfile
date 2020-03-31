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

  }
}