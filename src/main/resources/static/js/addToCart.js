/**
 * 
 */
 
 
 function ready()
 {
	var addCartbutton = document.getElementsByClassName("shop_item");
	for(var i=0;i<addCartbutton.length;i++)
	{
		var button = addCartbutton[i];
		button.addEventListener('click',addToCartClicked);
	}
}
 
 
 function addToCartClicked(event)
 {
	
	var button = event.target;
	var shopItem = button.parentElement;
	console.log(shopItem);
	var title = shopItem.getElementsByClassName("clothes")[0].innerText;
	var price = shopItem.getElementsByClassName("price")[0].innerText;
	var qty2 = shopItem.getElementsByClassName('qty')[0].value;
	console.log(qty2);
	var imageSrc = shopItem.getElementsByClassName("cloths_img")[0].src;
	console.log( title, price, imageSrc); 
	addItemToCart( title, price, imageSrc, qty2)
}

var totalCost=0;

function addItemToCart(title,price,imageSrc,qty2)
{
	var cartRow  = document.createElement("div");
//	var cartItems = document.getElementsByClassName('cart-items')[0];
	cartRow.innerText = title;
	var cartItems = document.getElementsByClassName("cart-items")[0];
	 totalCost = price * qty2;
	var cartRowContents = `
	<div class="cloth4">
        <img src="${imageSrc}" class="cloths_3" alt="blue shirt">
        <span class="cloths_4">${title}</span>
       
        <span class="qty4">${qty2}</span>
         <span class="price_4" name="price_4">${totalCost}</span>
        <button class="btn btn-danger rem_4" type="button" onclick="deleteProdFromCart()">REMOVE</button>
        </div>
`;

cartRow.innerHTML = cartRowContents;
	cartItems.append(cartRow);
	console.log("hello");
	CalculateTotalprice()

}


function CalculateTotalprice()
{
	if(document.getElementsByClassName('totalamt')[0] !=null)
	{
console.log('element present')
const element = document.getElementsByClassName("totalamt")[0];
element.remove();
}
var totalRows = document.getElementsByClassName('cloth4');
var total = 0;
for(let i=0;i<totalRows.length;i++)
{
total +=  parseInt(totalRows[i].getElementsByClassName("price_4")[0].innerText);

}
	var cartRow  = document.createElement("div");

var cartRowContent3 = `
	<div class="totalamt">
	<span>Total Cost: </span>
	<span id="totcost">${total}</span>
	</div>

`;
var cartItems = document.getElementsByClassName("cart-items")[0];

cartRow.innerHTML = cartRowContent3;
cartItems.append(cartRow);
console.log("hello");


console.log(total);
}

function deleteProdFromCart()
{
const element = document.getElementsByClassName("cloth4")[0];
element.remove();
CalculateTotalprice()
}


function sendTotalCostToController() {
  fetch("/user/purchase", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ totalCost: totalCost }),
  })
    .then((response) => {
      if (response.ok) {
        // Handle a successful response from the server
        return response.json();
      } else {
        // Handle an error response from the server
        throw new Error("Error sending total cost to server");
      }
    })
    .then((data) => {
      // Handle the response data if needed
      console.log(data);
    })
    .catch((error) => {
      // Handle any errors that occurred during the fetch request
      console.error(error);
    });
}

// Call the function when the "Purchase" link is clicked
document.getElementById("purchButton").addEventListener("click", sendTotalCostToController);
