package lab2_2;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceRequest;
import pl.com.bottega.ecommerce.sales.domain.invoicing.RequestItem;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class InvoiceRequestTest {

    InvoiceRequest request;

    @Before
    public void setUp() {
        request = new InvoiceRequest(new ClientData(Id.generate(), "Jan Kowalski"));
    }

    @Test
    public void invoiceRequestWithNoItemsAddedShouldBeEmpty() {
        assertThat(request.getItems(), hasSize(0));
    }

    @Test
    public void addedItemsToInvoiceRequestShouldRemainInRequest() {
        ProductData productData = new ProductData();
        RequestItem item = new RequestItem(productData, 2, new Money(12));
        request.add(item);
        assertThat(request.getItems(), hasSize(1));
        assertThat(request.getItems(), contains(item));
    }
}
