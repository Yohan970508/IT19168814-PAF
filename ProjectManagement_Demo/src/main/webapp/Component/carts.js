$(document).ready(function()
	{
	if ($("#alertSuccess").text().trim() == "")
	{
	$("#alertSuccess").hide();
	}
	$("#alertError").hide();
	});
	
// SAVE ============================================
	$(document).on("click", "#btnSave", function(event)
	{
		// Clear alerts---------------------
		$("#alertSuccess").text("");
		$("#alertSuccess").hide();
		$("#alertError").text("");
		$("#alertError").hide();
		
		// Form validation-------------------
	    var status = validateCartForm();
		if (status != true)
		{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
		}
		
		 // If valid------------------------
		 var type = ($("#hidCartIDSave").val() == "") ? "POST" : "PUT"; 
		 $.ajax( 
		 { 
		 url : "CartAPI", 
		 type : type, 
		 data : $("#formCart").serialize(), 
		 dataType : "text", 
		 complete : function(response, status) 
		 { 
		 onCartSaveComplete(response.responseText, status); 
		 } 
 	}); 
});
		
// UPDATE==========================================
	$(document).on("click", ".btnUpdate", function(event)
	{
	$("#hidCartIDSave").val($(this).data("cartid"));
	$("#Item_Code").val($(this).closest("tr").find('td:eq(0)').text());
	$("#Item_Name").val($(this).closest("tr").find('td:eq(1)').text());
	$("#Price").val($(this).closest("tr").find('td:eq(2)').text());
	$("#Qty").val($(this).closest("tr").find('td:eq(3)').text());
	});
	
// DELETE===========================================
	$(document).on("click", ".btnRemove", function(event)
	{ 
	 $.ajax( 
	 { 
	 url : "CartAPI", 
	 type : "DELETE", 
	 data : "CID=" + $(this).data("cartid"),
	 dataType : "text", 
	 complete : function(response, status) 
	 { 
	 onCartDeleteComplete(response.responseText, status); 
	 } 
	 }); 
});
// CLIENT-MODEL================================================================
function validateCartForm()
	{
	// CODE
	if ($("#Item_Code").val().trim() == "")
	{
	return "Insert Item Code.";
	}
	// NAME
	if ($("#Item_Name").val().trim() == "")
	{
	return "Insert Item Name.";
	}

	// PRICE-------------------------------
	if ($("#Price").val().trim() == "")
	{
	return "Insert Price.";
	}
	// is numerical value
	var tmpPrice = $("#Price").val().trim();
	if (!$.isNumeric(tmpPrice))
	{
	return "Insert a numerical value for Price.";
	}
	// convert to decimal price
	$("#Price").val(parseFloat(tmpPrice).toFixed(2));
	// DESCRIPTION------------------------
	if ($("#Qty").val().trim() == "")
	{
	return "Insert Item Quantity.";
	}
	return true;
}

function onCartSaveComplete(response, status)
	{ 
	if (status == "success") 
	 { 
	 var resultSet = JSON.parse(response); 
	 if (resultSet.status.trim() == "success") 
	 { 
	 $("#alertSuccess").text("Successfully saved."); 
	 $("#alertSuccess").show();
	 $("#divCartsGrid").html(resultSet.data); 
	 } else if (resultSet.status.trim() == "error") 
	 { 
	 $("#alertError").text(resultSet.data); 
	 $("#alertError").show(); 
	 } 
	 } else if (status == "error") 
	 { 
	 $("#alertError").text("Error while saving."); 
	 $("#alertError").show(); 
	 } else
	 { 
	 $("#alertError").text("Unknown error while saving.."); 
	 $("#alertError").show(); 
	 } 
	 $("#hidCartIDSave").val(""); 
	 $("#formCart")[0].reset(); 
}

function onItemDeleteComplete(response, status)
	{ 
	if (status == "success") 
	 { 
	 var resultSet = JSON.parse(response); 
	 if (resultSet.status.trim() == "success") 
	 { 
	 $("#alertSuccess").text("Successfully deleted."); 
	 $("#alertSuccess").show();
	 $("#divCartsGrid").html(resultSet.data); 
	 } else if (resultSet.status.trim() == "error") 
	 { 
	 $("#alertError").text(resultSet.data); 
	 $("#alertError").show(); 
	 } 
	 } else if (status == "error") 
	 { 
	 $("#alertError").text("Error while deleting."); 
	 $("#alertError").show(); 
	 } else
	 { 
	 $("#alertError").text("Unknown error while deleting.."); 
	 $("#alertError").show(); 
 } 
}