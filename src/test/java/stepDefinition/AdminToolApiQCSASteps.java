package stepDefinition;

import Utility.AdminToolApiQCSA;
import io.cucumber.java.en.And;
import seleniumhelper.BaseClass;

public class AdminToolApiQCSASteps extends BaseClass {
    AdminToolApiQCSA adminToolApiQCSA=new AdminToolApiQCSA();

    @And("^I POST Admin Tool Login QCSA$")
    public void iPOSTAdminToolLoginQCSA() {
        adminToolApiQCSA.postLogin();
    }

    @And("^I POST change \"([^\"]*)\" of id\"([^\"]*)\" for customer\"([^\"]*)\" property to \"([^\"]*)\"$")
    public void iPOSTChangeOfIdForCustomerPropertyTo(String propertyKey, String id, String custId, String propertyValue) throws Throwable {
        adminToolApiQCSA.updateAdminToolProperty(id,custId,propertyKey,propertyValue);
    }

    @And("^I GET Admin Tool Customers QCSA$")
    public void iGETAdminToolCustomersQCSA() {
        adminToolApiQCSA.getCustomers();
    }
}
