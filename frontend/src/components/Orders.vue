<template>
  <div class="container">
    <h3>Orders</h3>
    <div class="container">
      <table class="table" >
        <thead>
        <tr>
          <th>name</th>
          <th>address</th>
          <th>orderSum</th>
          <th>goods</th>
          <th>amount</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="order in orders" v-bind:key="order.id">
          <td>{{order.orderId.name }}</td>
          <td>{{order.orderId.address}}</td>
          <td>{{order.orderId.orderSum}}</td>
          <table class="innerTable">
            <thead>
            <th>serialNumber</th>
            <th>name</th>
            <th>address</th>
            <th>date</th>
            </thead>
            <tr v-for="(good, index) in order.goods"  v-bind:key="index" >
              <td>{{good.serialNumber}}</td>
              <td>{{good.name}}</td>
              <td>{{good.address}}</td>
              <td>{{good.goodDate}}</td>
            </tr>
          </table>
          <td>{{order.amount}}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import DataService from '@/service/DataService';
export default {
  name: "Orders",
  data(){
    return{
      orders:[],
      message: null
    };
  },
  methods: {
    refresh() {
      DataService.retrieveOrders()
          .then(response => {
            this.orders = response.data
          });

    }
  },
  created() {
    this.refresh();
  }
};
</script>

<style scoped>
.table{}
.innerTable{width: 100%; border: black; }
</style>