import com.project.lld.Customer;
import com.project.lld.Item;
import com.project.lld.ShoppingCart;
import com.project.lld.constants.RateConstants;
import com.project.lld.rule.Rule;
import com.project.lld.rule.RuleHandler;
import com.project.lld.rule.impl.OneDayDeliveryRule;
import com.project.lld.rule.impl.TwoDayDeliveryRule;
import com.project.lld.rule.impl.TwoHourDeliveryRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestClass {
    @Test
    void testForPrimeCustomer(){
        var primeCustomer = new Customer("Ankit", true);

        var groceryItem1 = new Item("Apples", 2, 180, true, false);
        var groceryItem2 = new Item("Mangoes", 4, 100, true, false);

        var cart = new ShoppingCart(primeCustomer);
        cart.addItem(groceryItem1);
        cart.addItem(groceryItem2);

        Rule twoDayDelivery = new TwoDayDeliveryRule(35);
        Rule oneDayDelivery = new OneDayDeliveryRule(125);
        Rule twoHourDelivery = new TwoHourDeliveryRule(25);

        var ruleHandler = new RuleHandler();

        ruleHandler.addRule(twoDayDelivery);
        ruleHandler.addRule(oneDayDelivery);
        ruleHandler.addRule(twoHourDelivery);

        ruleHandler.applyRules(cart);
        Assertions.assertEquals(760, cart.getCartTotal());
        Assertions.assertEquals(0, cart.getTwoDayDeliveryCharge());
        Assertions.assertEquals(0, cart.getOneDayDeliveryCharge());
        Assertions.assertEquals(0, cart.getTwoHourDeliveryCharge());

        var item1 = new Item("Plates", 6, 40, false, false);
        cart.addItem(item1);

        ruleHandler.applyRules(cart);
        Assertions.assertEquals(1000, cart.getCartTotal());
        Assertions.assertEquals(0, cart.getTwoDayDeliveryCharge());
        Assertions.assertEquals(0, cart.getOneDayDeliveryCharge());
        Assertions.assertEquals(RateConstants.TWO_HOUR_DELIVERY_CHARGE, cart.getTwoHourDeliveryCharge());
    }

    @Test
    void testForNonPrimeCustomer(){
        var primeCustomer = new Customer("Ankit", false);

        var groceryItem1 = new Item("Apples", 2, 180, true, false);
        var groceryItem2 = new Item("Mangoes", 4, 100, true, false);

        var cart = new ShoppingCart(primeCustomer);
        cart.addItem(groceryItem1);
        cart.addItem(groceryItem2);

        Rule twoDayDelivery = new TwoDayDeliveryRule(35);
        Rule oneDayDelivery = new OneDayDeliveryRule(125);
        Rule twoHourDelivery = new TwoHourDeliveryRule(25);

        var ruleHandler = new RuleHandler();

        ruleHandler.addRule(twoDayDelivery);
        ruleHandler.addRule(oneDayDelivery);
        ruleHandler.addRule(twoHourDelivery);

        ruleHandler.applyRules(cart);
        Assertions.assertEquals(760, cart.getCartTotal());
        Assertions.assertEquals(0, cart.getTwoDayDeliveryCharge());
        Assertions.assertEquals(0, cart.getOneDayDeliveryCharge());
        Assertions.assertEquals(RateConstants.TWO_HOUR_DELIVERY_CHARGE, cart.getTwoHourDeliveryCharge());

        var item1 = new Item("Plates", 6, 40, false, false);
        cart.addItem(item1);

        ruleHandler.applyRules(cart);
        Assertions.assertEquals(1000, cart.getCartTotal());
        Assertions.assertEquals(RateConstants.TWO_DAY_DELIVERY_CHARGE, cart.getTwoDayDeliveryCharge());
        Assertions.assertEquals(RateConstants.ONE_DAY_DELIVERY_CHARGE, cart.getOneDayDeliveryCharge());
        Assertions.assertEquals(RateConstants.TWO_HOUR_DELIVERY_CHARGE, cart.getTwoHourDeliveryCharge());
    }
}
