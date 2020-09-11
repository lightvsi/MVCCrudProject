import axios from "axios";

const GOOD_API_URL = "http://localhost:8080/goods";
const ORDER_API_URL = "http://localhost:8080/orders";
const TIME_API_URL = "http://localhost:8080/time";
const UPDATE_API_URL = "http://localhost:8080/update";

class DataService {
    retrieveGoods() {
        return axios.get(`${GOOD_API_URL}`);
    }
    retrieveOrders() {
    return axios.get(`${ORDER_API_URL}`);
}
    retrieveTime() {
        return axios.get(`${TIME_API_URL}`);
    }
    updateGoods(){
        return axios.get(`${UPDATE_API_URL}`);
    }
}

export default new DataService();