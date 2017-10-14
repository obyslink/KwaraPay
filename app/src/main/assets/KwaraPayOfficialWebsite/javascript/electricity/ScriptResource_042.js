﻿// Name:        Common.JQueryToolkitScripts.debug.js
// Assembly:    AjaxControlToolkit
// Version:     3.5.7.1213
// FileVersion: 3.5.7.1213
if (Sys && Sys.WebForms && Sys.WebForms.PageRequestManager && $act) {
    if (!$act.isPostBackActivatorHandled) {
        $act.isPostBackActivatorHandled = true;

        function pageLoaded(sender, args) {
            var panelsUpdated = args.get_panelsUpdated();
            for (var i = 0; i < panelsUpdated.length; i++) {
                $act.activateWidgets('#' + panelsUpdated[i].id + ' *');
            }
        }
        
        var prm = Sys.WebForms.PageRequestManager.getInstance();
        prm.add_pageLoaded(pageLoaded);
    }

    Sys.Application.add_load(function () {
        
        $act.init();
        
        var msAjaxFindFunc = window.$find;
        window.$find = function(componentName) {
            var widget = $act.behaviors[componentName];
            if (widget)
                return widget;

            if (msAjaxFindFunc)
                return msAjaxFindFunc(componentName);

            return null;
        };
    });
}
