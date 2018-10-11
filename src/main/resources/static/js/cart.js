var cart ={

};
cart.type='';
cart.items=[];
function addToCart(id,name,type,price,type){
    toggleAddToCartBtn(id);
    cartItem={}
    cartItem.id=id;
    cartItem.name=name;
    cartItem.type=type;
    cartItem.price=price;
    cartItem.quantity=1;
    cart.type=type;
    cart.items.push(cartItem);
    renderCartTable();
}

function addQuantity(product_id){
    for (var i = 0; i < cart.items.length; i++) {
        if (cart.items[i].product.product_id == product_id) {
            cart.items[i].product_qty++;
        }
    }
    renderCartTable();
}

function toggleAddToCartBtn(id){
    $('#addToCartBtn'+id).toggle();
    $('#quantityBtn'+id).toggle();
}

function renderCartTable() {
    var html = '';
    var ele = document.getElementById("bb-cart");
    ele.innerHTML = '';
    var total=0;
    var GrandTotal = 0;
    for (var i = 0; i < cart.items.length; i++) {
        html += "<li class='list-group-item d-flex justify-content-between lh-condensed'>";
        html += "<div>";
        html += "<h6 class='my-0'>"+cart.items[i]['name']+"</h6>";
        html += "<small class='text-muted'>"+cart.items[i]['type']+"</small>";
        html += "</div>";
        html += "<span class='text-muted'>"+cart.items[i]['price']+ " &times; " + cart.items[i]['quantity'] + "</span>";
        html += "</li>";
        total += cart.items[i]['price']*cart.items[i]['quantity'];
    }
    html += "<li class='list-group-item d-flex justify-content-between'>";
    html += "<span>Total (INR)</span>";
    html += "<strong>"+total+"</strong>";
    html += "</li>";
    ele.innerHTML = html;
}
function onAddQuantity(id){
    for (var i = 0; i < cart.items.length; i++) {
        if(cart.items[i]['id']===id){
            cart.items[i]['quantity']++;
            document.getElementById("quantityId"+id).innerHTML =parseInt(document.getElementById("quantityId"+id).innerHTML) +1;
        }
    }
    renderCartTable();
}
function onRemoveQuantity(id){
    for (var i = 0; i < cart.items.length; i++) {
        if(cart.items[i]['id']===id){
            if(cart.items[i]['quantity'] === 1){
                removeItem(id);
                toggleAddToCartBtn(id)
            }else{

            cart.items[i]['quantity']--;
            document.getElementById("quantityId"+id).innerHTML =parseInt(document.getElementById("quantityId"+id).innerHTML) -1;
            }
        }
    }
    renderCartTable();
}

function removeItem(product_id){
    for (var i = 0; i < cart.items.length; i++) {
        if (cart.items[i]['id'] == product_id) {
            cart.items.splice(i,1);
        }
    }
    renderCartTable();
}

function checkOut(){

}