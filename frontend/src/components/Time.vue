<template>
<h1 style="text-align: center; font-size: 26px">{{time}}</h1>
</template>

<script>
import DataService from '@/service/DataService';
export default {
  name: "Time",
  data() {
    return {
      time: null
    };
  },
  methods: {
    refresh() {
      DataService.retrieveTime()
          .then(response => {
            this.time = response.data;
          });
    }
  },
  created() {
    this.refresh();
  }
};
</script>

<style scoped>
</style>