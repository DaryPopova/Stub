package application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    DataKeeper dataKeeper = new DataKeeper();

    @RequestMapping("/addProduct")
    public Answer addProduct(@RequestParam(value="id", required=false) Integer id,
                           @RequestParam(value="name", required=false) String name,
                           @RequestParam(value="price", required=false) Double price){
        try {
            if ((id == null) || (name == null) || (price == null)) {
                return new Answer(400, "Bad Request");
            }
            dataKeeper.addProduct(id, name, price);
            return new Answer(200, "success");
        } catch (Exception e) {
            System.out.println(e);
            return new Answer(500, "Internal Server Error");
        }
    }

    @RequestMapping("/getProduct")
    public JsonObject getProduct(@RequestParam(value="id", required=false) Integer id) throws Exception {
        try {
            if (id == null) {
                return new Answer(400, "Bad Request");
            }
            else if (!dataKeeper.keeper.containsKey(id)) {
                return new Answer(404, "Not Found");
            }

            return new Product(dataKeeper.getProduct(id).getId(), dataKeeper.getProduct(id).getName(),
                    dataKeeper.getProduct(id).getPrice());
        } catch (Exception e) {
            return new Answer(404, "Not Found");
        }

    }
}