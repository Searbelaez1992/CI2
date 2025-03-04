package org.example.Facade;

import org.example.pages.CartPage;

public class CartFacade {

    private CartPage cartPage;

    public CartFacade(CartPage cartPage) {
        this.cartPage = cartPage;
    }

    public void doTheCheckout() {
        cartPage.clickOnCheckoutButton();
    }
    public void goToTheCartButton(){
        cartPage.clickOngoToTheCartButton();
    }
    public int sizeOfelementsOfTheCart(){
        return cartPage.sizeOfelementsOfTheCart();
    }

    public void addAmountOfTheBook(int numberOfTheBook, int numberOfAmount){

        for(int i = 0;i <  numberOfAmount; i++){
            cartPage.clickOnelementsToAddTheAmountOfTheBooks(numberOfTheBook);
            try {
                Thread.sleep( 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void deleteTheBook(int numberOfTheBook,int numberOfAmount){
        for(int i = 0;i <  numberOfAmount; i++){
            cartPage.clickOnelementsToDeleteTheBooks(numberOfTheBook);
            try {
                Thread.sleep( 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
}