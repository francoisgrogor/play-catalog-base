$ ->
  $.get "/categories", (data) ->
    $.each data, (index, item) ->
      $("#categories").append "<li>Category " + item.name + "</li>"