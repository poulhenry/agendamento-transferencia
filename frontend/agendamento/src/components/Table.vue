<script setup>
import axios from 'axios';
import { ref, onMounted } from 'vue';

const appointments = ref(null)
const loading = ref(true)
const error = ref(null)

const getAppointments = async() => {
    try {
        const response = await axios.get("http://localhost:8080/agendamento")
        appointments.value = response?.data?.map(appointment => ({
            ...appointment,
            value: formatCurrency(appointment.value),
            tax: formatCurrency(appointment.tax),
            schedulingDate: formatDate(appointment.schedulingDate)
        }));
    } catch (err) {
        error.value = "Erro ao carregar dados do servidor.";
        console.log(err)
    } finally {
        loading.value = false
    }
}

const formatCurrency = (value) => {
    if (value == null) return "---";

    return new Intl.NumberFormat('pt-BR', {
        style: "currency",
        currency: "BRL"
    }).format(value)
}

const formatDate = (date) => {
    if (!date) return "";

    const [year, month, day] = date.split('-');
    return `${day}/${month}/${year}`;
}

onMounted(() => {
    getAppointments()
})

defineExpose({
    getAppointments
})

</script>

<template>
    <div class="overflow-x-auto rounded-box border border-base-content/5 bg-base-100">
        <table class="table">
            <thead>
                <tr>
                    <th></th>
                    <th>Conta origem</th>
                    <th>Conta destino</th>
                    <th>Valor</th>
                    <th>Taxa</th>
                    <th>Data Transferência</th>
                </tr>
            </thead>
            <tbody class="w-full">
                <tr v-if="loading">
                    <th colspan="6">
                        <div class="flex flex-col justify-center items-center">
                                <span class=" loading loading-dots loading-xl"></span>
                                <p>Carregando...</p>
                        </div>
                    </th>
                </tr>
                <tr v-else-if="error">
                    <th colspan="6" class="text-center text-red-300">{{ error }}</th>
                </tr>
                <tr v-else-if="!appointments || appointments?.length == 0">
                    <th colspan="6" class="text-center">Sem informações</th>
                </tr>
                <tr v-else v-for="appointment in appointments" :key="appointment.id">
                    <th>{{ appointment.id }}</th>
                    <td>{{ appointment.originAccount }}</td>
                    <td>{{ appointment.destinationAccount }}</td>
                    <td>{{ appointment.value }}</td>
                    <td>{{ appointment.tax }}</td>
                    <td>{{ appointment.schedulingDate }}</td>
                </tr>
            </tbody>
      </table>
    </div>
</template>