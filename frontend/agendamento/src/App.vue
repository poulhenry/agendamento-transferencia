<script setup>
import { ref } from 'vue';
import Table from './components/Table.vue';
import Modal from './components/Modal.vue';

const modalRef = ref(null)
const appointments = ref(null)

const handleClik = () => {
    if (modalRef.value) {
        modalRef.value.onOpenModal()
    }
}

const handleFetchAppointments = () => {
    appointments.value.getAppointments()
}

</script>

<template>
  <main class="h-screen flex flex-col">
    <div class="mx-auto mb-auto mt-36 flex flex-col gap-2">
        <div class="flex justify-end">
            <button @click="handleClik" class="btn btn-soft btn-primary">Agendar</button>
        </div>
        <Table ref="appointments" />
    </div>
    <Modal ref="modalRef" @set-appointments="handleFetchAppointments"/>
  </main>
</template>
