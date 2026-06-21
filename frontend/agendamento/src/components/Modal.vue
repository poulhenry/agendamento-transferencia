<script setup>
import { maskCurrency, demaskCurrency } from '@/utils/formatterCurrency';
import axios from 'axios';
import { ref, useTemplateRef } from 'vue';

const emit = defineEmits(['setAppointments'])

const modalRef = useTemplateRef('modalRef');
const formData = ref({
    originAccount: '',
    destinationAccount: '',
    value: '',
    schedulingDate: ''
})
const loading = ref(false)
const error = ref(null)

const handleSubmitForm = async() => {
    loading.value = true;
    error.value = null;

    try {
        const response = await axios.post("http://localhost:8080/agendamento", {...formData.value, value: demaskCurrency(formData.value.value)})

        if (response?.status === 201) {
            emit('setAppointments', response.data)
            onCloseModal()
            clearFields()
        }
    } catch (err) {
        console.log(error.response)
        error.value = err.response.data.message
    } finally {
        loading.value = false
    }
}

function onOpenModal() {
  if (modalRef.value) {
    modalRef.value.showModal()
  }
}

function onCloseModal() {
    if (modalRef.value) {
        modalRef.value.close()
        clearFields()
    }
}

const handleInputValue = (event) => {
    const inputValue = event.target.value;
    formData.value.value = maskCurrency(inputValue)
}

const clearFields = () => {
    formData.value = {
        originAccount: '',
        destinationAccount: '',
        value: '',
        schedulingDate: ''
    }
}

defineExpose({
    onOpenModal
})
</script>

<template>
    <dialog id="modalAgendamento" class="modal" ref="modalRef">
        <div class="modal-box">
            <h3 class="text-lg font-bold">Agendar uma transferência</h3>
            <div class="modal-action">
                <form @submit.prevent="handleSubmitForm" method="dialog" class="w-full flex flex-col">
                    <div class="flex gap-4">
                        <fieldset class="fieldset flex-1">
                            <legend class="fieldset-legend">Conta Origem</legend>
                            <input 
                                v-model="formData.originAccount"
                                type="text"
                                class="input"
                                placeholder="Digite a conta de origem" 
                                required
                                :disabled="loading"
                            />
                        </fieldset>

                        <fieldset class="fieldset flex-1">
                            <legend class="fieldset-legend">Conta Destino</legend>
                            <input 
                                v-model="formData.destinationAccount"
                                type="text"
                                class="input"
                                placeholder="Digite a conta de destino"
                                required
                                :disabled="loading"
                            />
                        </fieldset>
                    </div>
                    <div class="flex gap-4">
                        <fieldset class="fieldset flex-1">
                            <legend class="fieldset-legend">Valor a Transferir</legend>
                            <input 
                                v-model="formData.value"
                                type="text"
                                class="input"
                                placeholder="R$ 0,00"
                                @input="handleInputValue"
                                required
                                :disabled="loading"
                            />
                        </fieldset>

                        <fieldset class="fieldset flex-1">
                            <legend class="fieldset-legend">Data de Agendamento</legend>
                            <input v-model="formData.schedulingDate" type="date" class="input" required :disabled="loading"/>
                        </fieldset>
                    </div>

                    <div class="w-full flex justify-end gap-4 mt-4">
                        <button @click="onCloseModal" type="button" class="btn btn-sm btn-circle btn-ghost absolute right-2 top-2">✕</button>
                        <button type="submit" class="btn btn-primary" :disabled="loading">Agendar</button>
                    </div>
                </form>
            </div>
        </div>
        <div v-if="error" class="toast toast-top toast-end">
            <div class="alert alert-error">
                <span>{{ error }}</span>
            </div>
        </div>
    </dialog>
    
</template>