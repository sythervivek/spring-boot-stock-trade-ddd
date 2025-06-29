# STOCK TRADING APPLICATION

The application is structured using Domain Driven Design Concepts, with Java modules and Spring boot.
The application consists of Order and Portfolio apis.

## Entities
Currently, there 2 entities considered in the application:
* #### Order
    Entity to initiate a Stock purchasing or selling request. It consist of information about the user initiating the request, stock to purchase or sell and their quantity.

* #### Portfolio
    Entity represents the current portfolio of a user (stocks invested in and current amount remaining in account after purchase)

## V1 Apis
Currently, there are 2 sets REST of Apis creates for both entities:
 * #### Order Apis
   *     Create order api: URL - http://localhost:8080/v1/orders/order
         Request Sample - { "id": "5d8aa31a-1298-45db-b5ab-9a4b32a67b95", "userId": "1d8aa31a-1298-45db-b5ab-9a4b32a67b95", "stockId": "2d8aa31a-1298-45db-b5ab-9a4b32a67b95", "quantity": 100.00, "orderType": "BUY_ORDER" }
   *     Get order api: URL - http://localhost:8080/v1/orders/order/7b8e4ce4-a252-473c-b40b-90bd2aee5ebb
 * #### Portfolio Apis
   *      Create Portfolio api: URL - http://localhost:8080/v1/portfolios/portfolio
          Request sample - { "userId": "1d8aa31a-1298-45db-b5ab-9a4b32a67b95" }
   *      Get Portfolio Api: URL - http://localhost:8080/v1/portfolios/1d8aa31a-1298-45db-b5ab-9a4b32a67b95
## V2 Apis
V2 apis are the reactive version of V1 api. Since the stock trading application deals with highly realtime data. having reactive api could do the job better.
* #### Order Apis
    *     Create order api: URL - http://localhost:8080/v2/orders/order
          Request Sample - { "id": "5d8aa31a-1298-45db-b5ab-9a4b32a67b95", "userId": "1d8aa31a-1298-45db-b5ab-9a4b32a67b95", "stockId": "2d8aa31a-1298-45db-b5ab-9a4b32a67b95", "quantity": 100.00, "orderType": "BUY_ORDER" }
    *     Get order api: URL - http://localhost:8080/v1/orders/order/7b8e4ce4-a252-473c-b40b-90bd2aee5ebb
* #### Portfolio Apis
    *      Create Portfolio api: URL - http://localhost:8080/v2/portfolios/portfolio
           Request sample - { "userId": "1d8aa31a-1298-45db-b5ab-9a4b32a67b95" }
    *      Get Portfolio Api: URL - http://localhost:8080/v1/portfolios/1d8aa31a-1298-45db-b5ab-9a4b32a67b95