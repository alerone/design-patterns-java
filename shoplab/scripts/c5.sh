#!/usr/bin/env bash

$(curl -i -H "Content-Type: application/json" \
-d '{"id":"p1","name":"Teclado", "price":{"amount":49.9,"currency":"EUR"}, "kind":{"type":"physical","weightGrams":800}, "stock":12,"category":"hardware"}' \
http://localhost:8080/products)

response=$(curl  -H "Content-Type: application/json" -X POST localhost:8080/orders \
    -d '{"items":[{"productId":"p1","quantity":2}],"shippingAddress":{"recipient":"Ana","street":"Calle Sol 1","city":"Madrid"},"region":"ES","paymentType":"CARD"}')

echo Se crea un order
echo $response 

P1=$(echo $response | jq -r '.id')
echo se muestra el id del order
echo $P1
curl -i -X POST "localhost:8080/orders/$P1/checkout"  
curl -i -X POST "localhost:8080/orders/$P1/checkout?channel=sms" 
curl -i -X POST "localhost:8080/orders/$P1/checkout?channel=fax" 
curl -i -X POST "localhost:8080/orders/zz/checkout" 
