/**
 * Created by mjali on 03/11/2016.
 */
var app = angular.module('app', ['ngRoute', 'ngResource', 'ngCookies', 'ngTouch', 'ngSanitize', 'ngLocale', 'pascalprecht.translate', 'tmh.dynamicLocale']);
app.config(function ($routeProvider) {
    $routeProvider
        .when('/users', {
            templateUrl: '/views/users.html',
            controller: 'usersController'
        })
        .when('/roles', {
            templateUrl: '/views/roles.html',
            controller: 'rolesController'
        })
        .otherwise(
            {redirectTo: '/'}
        );
}).constant('LOCALES', {
    'locales': {
        'fr_fr': 'Français',
        'en_US': 'English'
    },
    'preferredLocale': 'fr_fr'
}).config(function ($translateProvider) {
    $translateProvider.useMissingTranslationHandlerLog();
    $translateProvider.useStaticFilesLoader({
        prefix: 'locale/locale-',
        suffix: '.json'
    });
    $translateProvider.preferredLanguage('fr_fr');
    $translateProvider.useLocalStorage();
    $translateProvider.useSanitizeValueStrategy('escape');
}).config(function (tmhDynamicLocaleProvider) {
    tmhDynamicLocaleProvider.localeLocationPattern('/webjars/angularjs/1.5.8/i18n/angular-locale_{{locale}}.js');
});
