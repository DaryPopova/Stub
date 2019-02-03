package application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    DataKeeper dataKeeper = new DataKeeper();

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public ResponseEntity<JsonObject> addProduct(@RequestBody Product product){
        try {
            if ((product.getId() == null) || (product.getName() == null) || (product.getPrice() == null)) {
                return new ResponseEntity<>(new Answer(400, "Bad Request"), HttpStatus.BAD_REQUEST);
            }
            if (product.getPrice() < 0) {
                return new ResponseEntity<>(new Answer(500, "Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            dataKeeper.addProduct(product);
            return new ResponseEntity<>(new Answer(200, "success"), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(new Answer(500, "Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/getProduct")
    public ResponseEntity<JsonObject> getProduct(@RequestParam(value="id", required=false) Integer id) throws Exception {
        try {
            if (id == null) {
                return new ResponseEntity<>(new Answer(400, "Bad Request"), HttpStatus.BAD_REQUEST);
            }
            else if (!dataKeeper.keeper.containsKey(id)) {
                return new ResponseEntity<>(new Answer(404, "Not Found"), HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(dataKeeper.getProduct(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Answer(404, "Not Found"), HttpStatus.NOT_FOUND);
        }

    }
}