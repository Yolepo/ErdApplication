/**
 * Created by mjali on 05/11/2016.
 */
angular.module('app').directive('ngTranslateLanguageSelect', function (LocaleService) {
    'use strict';
    return {
        restrict: 'A',
        replace: true,
        template: '' +

        '<select class="form-control" ng-model="currentLocaleDisplayName"' +
        'ng-options="localesDisplayName for localesDisplayName in localesDisplayNames"' +
        'ng-change="changeLanguage(currentLocaleDisplayName)">' +
        '</select>' +
        '',
        controller: function ($scope) {
            $scope.currentLocaleDisplayName = LocaleService.getLocaleDisplayName();
            $scope.localesDisplayNames = LocaleService.getLocalesDisplayNames();
            $scope.visible = $scope.localesDisplayNames &&
                $scope.localesDisplayNames.length > 1;

            $scope.changeLanguage = function (locale) {
                LocaleService.setLocaleByDisplayName(locale);
            };
        }
    };
});