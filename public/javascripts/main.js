

$(function() {
  $(".goods").mouseover(function(){
  var $name=$(this).find('.goodsName');
   $name.removeClass("hidden");
  }).mouseout(function(){
    $(".goodsName").addClass("hidden");
  });
});