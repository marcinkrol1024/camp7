TASK 1
------

Create table towns

towns
* id: bigserial primary key
* name: text
* inhabitants_count: int

insert into the table rows:
'Warszawa' 200
'Wroclaw' 300
'Gdansk' 400
'Krakow' 500
'Opole' 600

select rows with inhabitant 400 <= count <= 650

TASK 2
------

Create notebook class, insert a few instances into db

Notebook
* model: String
* resolution: int
* productionTimestamp: Instant

TASK 3
------

Create town class
Add town field to User, create one to one relationship

Town
* name
* inhabitantsCount

TASK 4
------

Create building class
Add users field to Building, create one to many relationship

Building
* address
* users

TASK 5
------

Create below model, insert some data to database, review created schema

Wallet
* amount
* owner: Customer - one-one

Customer
* name
* age
* cars - one-many

Car
* model: String

Shop
* name: String
* products: List<Product> - many-many

Product
* price
* name

TASK 6
------
Twitter
Chcemy stworzyć model oraz warstwę dostępu dla aplikacji Twitter. Założenia modelu:
- użytkownik ma login, mail, hasło
- użytkownik może dodawać tweety (każdy tweet jest przypisany tylko do jednego użytkownika, który go dodał)
- tweet ma długość 140 znaków, datę dodania oraz może dostawać pozytywne i negatywne głosy (nie musimy wiedzieć od kogo)
- tweet może zawierać w treści oznaczenie innego użytkownika (za pomocą małpy @), np: "Hej @bartektartanus zobacz co znalazłem w sieci"
- tweet może zawierać w treści hash-tag oznaczony krzyżykiem - #, np: "jestem właśnie na meczu #polska #włochy"
 
Oczekiwane funkcjonalności:
- zapis użytkownika oraz jego tweetów
- wyszukiwanie użytkownika zarówno po loginie jak i po mailu
- wyszukiwanie N najlepiej ocenianych tweetów użytkownika
- wyszukiwanie N najlepiej ocenianych tweetów według hashtaga
- wyszukiwanie wszystkich tweetów, w których oznaczony został dany użytkownik
- wyszukiwanie wszystkich tweetów z bieżącego dnia

TASK 7
------
Create Shops class

Create dao to add/delete/read shops by name substring

Create tests

Shop
 * id
 * name
 * address
 
TASK 8
------
Add ShopNativeSqlDao implementation, use native queries instead of jpqls for reading.

Add squareMeters field to shop, add sumSquareMetersForNameSubstring(nameSubstring) method to dao.

TASK 9
------
Add ShopNamedQueryDao implementation, use named queries instead of jpqls for reading.

TASK 10
-------
Create a simple tracker.

*Part 1*<br>
Create user class with username and password<br>
Create dao to add users and to find user with a username<br>
*Part 2*<br>
Create project class with description and assigned users<br>
Create dao to create projects and assign users to projects<br>

**For advanced only**<br>
Users should log in with username and password
Users should be able to create projects
Users should be able to define tasks within projects
Users should be able to view tasks assigned to a project
Users should be able to view projects list
Users should be able to assign users to tasks
Users should be able to mark tasks as resolved
Tasks should initially be unresolved