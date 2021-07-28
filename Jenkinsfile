jsl = library(identifier: 'utils-lib@snapshot', retriever: legacySCM(scm))
def testApi = jsl.com.kmochocki.showcase.jenkins.TestApi.new()

pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                script {
                    echo 'Hello World'
                    def kokos = testApi.getApi()
                }
            }
        }
    }
}
