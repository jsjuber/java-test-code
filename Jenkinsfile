pipeline {
  agent any
  stages {
    stage('error') {
      agent {
        docker {
          image 'image'
        }

      }
      steps {
        echo 'hello'
      }
    }

  }
}