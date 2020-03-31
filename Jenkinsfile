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
        sh '''#!/bin/bash

docker run -dit --name webserver nginx:latest /bin/bash'''
      }
    }

  }
}