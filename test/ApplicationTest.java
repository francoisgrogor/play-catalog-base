import static play.test.Helpers.fakeApplication;

import java.util.HashMap;
import java.util.Map;

import models.Category;
import models.Item;

import org.junit.Ignore;
import org.junit.Test;

import play.data.Form;
import play.libs.WS;
import play.mvc.Content;
import play.mvc.Result;
import play.test.FakeRequest;
import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.*;

// todo: not using the right spring context when using fakeApplication()
public class ApplicationTest {

    @Test
    @Ignore
    public void indexTemplate() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Form<Category> form = Form.form(Category.class);
                Content html = views.html.index.render(form);
                assertThat(contentType(html)).isEqualTo("text/html");
                assertThat(contentAsString(html)).contains("Welcome");
            }
        });
    }

    @Test
    @Ignore
    public void callIndex() {
        Result result = callAction(controllers.routes.ref.Application.index());
        assertThat(status(result)).isEqualTo(OK);
        assertThat(contentType(result)).isEqualTo("text/html");
        assertThat(charset(result)).isEqualTo("utf-8");
        assertThat(contentAsString(result)).contains("Welcome");
    }

    @Test
    @Ignore
    public void callCreateItem() {
        running(fakeApplication(), new Runnable() {
            public void run() {
//                Map<String, String> formParams = new HashMap<String, String>();
//                formParams.put("name", "foo");
//                
//                FakeRequest fakeRequest = fakeRequest().withFormUrlEncodedBody(formParams);
//                
//                Result result = callAction(controllers.routes.ref.Application.createItem(), fakeRequest);
//                assertThat(status(result)).isEqualTo(SEE_OTHER);
            }
        });
    }
    
    @Test
    public void callCreateCategory() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Map<String, String> formParams = new HashMap<String, String>();
                formParams.put("Bread", "Brown Bread");
                
                FakeRequest fakeRequest = fakeRequest().withFormUrlEncodedBody(formParams);
                
                Result result = callAction(controllers.routes.ref.Application.createCategory(), fakeRequest);
                assertThat(status(result)).isEqualTo(SEE_OTHER);
            }
        });
    }

    @Test
    @Ignore
    public void callFindAllItems() {
        running(fakeApplication(), new Runnable() {
            public void run() {
//                Map<String, String> formParams = new HashMap<String, String>();
//                formParams.put("name", "foo");
//
//                FakeRequest fakeRequest = fakeRequest().withFormUrlEncodedBody(formParams);
//
//                callAction(controllers.routes.ref.Application.createItem(), fakeRequest);
//                
//                Result result = callAction(controllers.routes.ref.Application.findAllItems());
//                assertThat(status(result)).isEqualTo(OK);
//                assertThat(contentType(result)).isEqualTo("application/json");
//                assertThat(contentAsString(result)).startsWith("[");
//                assertThat(contentAsString(result)).contains("foo");
            }
        });
    }

    @Test
    @Ignore
    public void itemsRoute() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Result result = route(fakeRequest(GET, "/items"));
                assertThat(result).isNotNull();
            }
        });
    }

    @Test
    @Ignore
    public void realItemsRequest() {
        running(testServer(3333), new Runnable() {
            public void run() {
                assertThat(WS.url("http://localhost:3333/items").get().get().getStatus()).isEqualTo(OK);
            }
        });
    }

}
