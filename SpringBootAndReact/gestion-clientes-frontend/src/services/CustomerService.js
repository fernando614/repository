//importo axios
import axios from "axios"

//aquí escribo la api que hice en spring para obtener los customers
const CUSTOMER_BASE_REST_API_URL = "http://localhost:8080/api/customers"
class CustomerService{
    getAllCustomers(){
        //aquí axios me ayuda pasandole la api
        return axios.get(CUSTOMER_BASE_REST_API_URL);
    }
    //le paso el cliente que voy a guardar
    createCustomer(customer){
        return axios.post(CUSTOMER_BASE_REST_API_URL,customer);
    }
    //método para obtener el id de un cliente
    getCustomerById(id){
        return axios.get(CUSTOMER_BASE_REST_API_URL+ "/" +id);
    }

    //método para actualizar al cliente
    updateCustomerById(id,customer){
        return axios.put(CUSTOMER_BASE_REST_API_URL + "/" + id,customer);
    }

    deleteCustomer(id){
        return axios.delete(CUSTOMER_BASE_REST_API_URL + "/" + id);
    }
}
//exportamos este servicio para usarlo desde otras clases
export default new CustomerService();