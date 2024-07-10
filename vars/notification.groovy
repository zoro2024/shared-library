def call() {
  slackSend channel: 'build-status',
  message: "Pipeline status: ${currentBuild.currentResult} ${env.JOB_NAME} ${env.BUILD_NUMBER} ${BUILD_URL}"
}
