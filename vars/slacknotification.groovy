def call(String status) {
    if (status == 'SUCCESS') {
            slackSend channel: 'build-status', message: 'Job Build successfully'
    }
    if (status == 'FAILURE'){
            slackSend channel: 'build-status', message: 'Job Failed'
    }
}
