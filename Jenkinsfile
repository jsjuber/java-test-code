pipeline {
  agent {
    docker {
      args '-p 80:80'
      image 'nginx:latest'
    }

  }
  stages {
    stage('build') {
      steps {
        sh '''
service nginx start'''
      }
    }

  }
}