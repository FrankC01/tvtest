
// Main entry point for TVMK-Kit

App.onLaunch = function(options) {

  evaluateScripts([`${options.BASEURL}js/core.js`], function(success) {

    if(success) {

      var alert = tvtest.core.createAlert("Hello", "Simple Modal Screen (altertTemplate)");
      navigationDocument.presentModal(alert);

    } else {

      var errorDoc = tvtest.core.createAlert("Evaluate Scripts Error",
                                              "Error attempting to evaluate external JavaScript files.");
      navigationDocument.presentModal(errorDoc);

    }
  });
}

