package top.cciradih.spring.rest.docs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.request.ParameterDescriptor;
import org.springframework.restdocs.request.RequestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureRestDocs("target/generated-snippets")
public class RestdocsApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getIndex() throws Exception {
        this.mockMvc.perform(RestDocumentationRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcRestDocumentation.document("{class-name}/{method-name}"));
    }

    @Test
    public void getUser() throws Exception {
        ParameterDescriptor[] descriptors = new ParameterDescriptor[]{
                RequestDocumentation.parameterWithName("id").description("User's ID")
        };
        FieldDescriptor[] user = new FieldDescriptor[]{
                PayloadDocumentation.subsectionWithPath("").description("User's Info"),
                PayloadDocumentation.fieldWithPath(".id").description("User's ID"),
                PayloadDocumentation.fieldWithPath(".name").description("User's name"),
                PayloadDocumentation.fieldWithPath(".email").description("User's E-mail")
        };

        this.mockMvc.perform(RestDocumentationRequestBuilders.get("/user/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcRestDocumentation.document(
                        "{class-name}/{method-name}",
                        RequestDocumentation.pathParameters(descriptors),
                        PayloadDocumentation.responseFields().andWithPrefix("user", user)
                ));
    }

    @Test
    public void getUsers() throws Exception {
        FieldDescriptor[] users = new FieldDescriptor[]{
                PayloadDocumentation.subsectionWithPath("").description("An array of user's info"),
                PayloadDocumentation.fieldWithPath(".id").description("User's ID"),
                PayloadDocumentation.fieldWithPath(".name").description("User's name"),
                PayloadDocumentation.fieldWithPath(".email").description("User's E-mail")
        };

        this.mockMvc.perform(RestDocumentationRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcRestDocumentation.document(
                        "{class-name}/{method-name}",
                        PayloadDocumentation.responseFields().andWithPrefix("users[]", users)
                ));
    }

    @Test
    public void postUser() throws Exception {
        ParameterDescriptor[] descriptors = new ParameterDescriptor[]{
                RequestDocumentation.parameterWithName("name").description("User's name"),
                RequestDocumentation.parameterWithName("email").description("User's E-mail")
        };
        FieldDescriptor[] user = new FieldDescriptor[]{
                PayloadDocumentation.subsectionWithPath("").description("User's Info"),
                PayloadDocumentation.fieldWithPath(".id").description("User's ID"),
                PayloadDocumentation.fieldWithPath(".name").description("User's name"),
                PayloadDocumentation.fieldWithPath(".email").description("User's E-mail")
        };


        this.mockMvc.perform(RestDocumentationRequestBuilders.post("/user")
                .param("name", "Cciradih")
                .param("email", "hidarichaochen@gmail.com")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcRestDocumentation.document(
                        "{class-name}/{method-name}",
                        RequestDocumentation.requestParameters(descriptors),
                        PayloadDocumentation.responseFields().andWithPrefix("user", user)
                ));

    }
}
