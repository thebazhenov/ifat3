# homework 1 AQA

## Xpath

1. Поиск по атрибуту и тэгу
`//button[@name='add-to-cart-sauce-labs-backpack']`
2. Поиск по тексту
`//*[text()='Sauce Labs Backpack']`
3. Поиск через contains() проверяет, содержит ли строка подстроку
`//*[contains(text(), 'A red light')]`
4. Поиск через starts-with() проверяет, начинается ли строка с указанного значения
`//*[starts-with(text(),'carry')]`
5. Комбинированный поиск
`//*[starts-with(text(),'carry')][@class='inventory_item_desc']`
6. Поиск через родителей
`//button[text()='Remove']/ancestor::div[contains(@class, 'inventory_item')]//div[starts-with(text(), 'carry.')]`


## CSS-Selector

1. Поиск по классу (.)
`a.shopping_cart_link`
2. Поиск по id (#)
`#add-to-cart-sauce-labs-bolt-t-shirt`
3. Поиск по атрибуту
`a[href='https://twitter.com/saucelabs']`
4. Начинается с (^=)
`div[class^='footer']`
5. Заканчивается на ($=)
`select[class$='sort_container']`
6. Содержит подстроку (*=)
`option[value*='hilo']`
7. Поиск по классу и атрибуту
`img.inventory_item_img[alt='Sauce Labs Bike Light']`