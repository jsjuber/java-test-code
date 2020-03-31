pipeline {
  agent {
    docker {
      image 'nginx'
    }

  }
  stages {
    stage('error') {
      agent any
      steps {
        echo 'hello'
      }
    }

  }
}