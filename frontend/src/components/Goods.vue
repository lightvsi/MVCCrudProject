<template>
  <div class="container">
    <h3>Goods</h3>
    <div class="container" >
      <table class="table" :key="componentKey">
        <thead>
        <tr>
          <th>serialNumber</th>
          <th>name</th>
          <th>address</th>
          <th>goodDate</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="good in goods" v-bind:key="good.serialNumber">
          <td>{{good.serialNumber}}</td>
          <td>{{good.name}}</td>
          <td>{{good.address}}</td>
          <td>{{good.goodDate}}</td>
        </tr>
        </tbody>
      </table>
      <button class="btn btn-warning" style="align-self: auto" v-on:click="this.forceRerender">
        Refresh
      </button>
    </div>
  </div>
</template>

<script>
import DataService from '@/service/DataService';
export default {
  name: "Goods",
  data(){
    return{
      goods:[],
      message: null,
      componentKey: 0
    };
  },
  methods: {
    refresh() {
      DataService.retrieveGoods()
          .then(response => {
            this.goods = response.data;
          });
    },
    update() {
      DataService.updateGoods()
          .then(response => {
            this.goods = response.data;
          });
    },
    forceRerender() {
      this.update();
      this.componentKey += 1;
    }
  },
  created() {
    this.refresh();
  },
};
</script>

<style scoped>
</style>