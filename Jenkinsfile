jsl = library(identifier: 'utils-lib@snapshot', retriever: legacySCM(scm))
def testApi = jsl.com.kmochocki.showcase.jenkins.TestApi.new()

pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
                testApi.getApi()
            }
        }
    }
}
