pipeline {
  agent {
    docker {
      args '-p 80:80'
      image 'nginx:latest'
    }

  }
  stages {
    stage('ok') {
      steps {
        echo 'test ok'
      }
    }

    stage('build') {
      steps {
        sh '''
docker run -dit nginx:latest /bin/bash'''
      }
    }

  }
}