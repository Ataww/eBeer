$(document).ready(function(){
  $('input.autocomplete').each( function() {
    var $input = $(this);
    // Set-up the autocomplete widget.
    $(this).autocomplete({
        minLength: 3,
        source : function(req, resp) {
          $.getJSON("getbeersbyname?term=" + req.term, function(data) {
            var suggestions = [];
            $.each(data, function(i, val) {
              var obj = {};
              obj.label = val.name;
              obj.id = val.id;
              suggestions.push(obj);
            });
            resp(suggestions);
          });
        }
      });
  });
});