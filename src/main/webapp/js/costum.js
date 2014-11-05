 $().ready(function(){
	$(".menu-container").click(function(){
		menu=$(this).children().attr('class');
		$(".menu-container").animate({
			    width:'100px',
			    opacity:'0,3'
			  });
		$(this).css('opacity','1');
		switch($.trim(menu)){
		case 'menu-container-1':$(".mainContent").load("articles.jsp"); break;
		case 'menu-container-2':$(".mainContent").load("familles.jsp"); break;
		case 'menu-container-3':$(".mainContent").load("groupes.jsp"); break;
		default: $(".mainContent").load("articles.jsp");
		}
		
	});
});