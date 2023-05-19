package com.atividade;

public class ListaOrdenada {
    public No head;
    public No atual;
    public No anterior;

    public void addOrdered(Integer value){
        No newValue = new No(value);
        boolean encontraPosicao = false;
        this.atual = head;

        if(isEmpty()){
            this.head = newValue;
            this.anterior = head;
        }
        else {
            do{
                if(value < this.atual.value ){
                    newValue.next = this.atual;
                    if(this.anterior == head){
                        head = newValue;
                        this.anterior = head;
                        encontraPosicao = true;
                    }else {
                        this.anterior.next = newValue;
                        encontraPosicao = true;
                    }
                } else if (value > this.atual.value && this.atual.next == null || value.equals(this.atual.value) && this.atual.next == null){
                    this.atual.next = newValue;
                    encontraPosicao = true;
                }
                else {
                    this.anterior = this.atual;
                    this.atual = this.atual.next;
                }
            }while (!encontraPosicao);
        }

    }
    public void delete(Integer value){
        boolean encontraPosicao = false;
        this.atual = head;

        do{
            if (this.atual.value.equals(value)) { //se achou o valor
                this.anterior.next = this.atual.next;
                this.atual = this.anterior;
                encontraPosicao = true;
            }else { //se não achou o valor, percorre a lista
                this.anterior = this.atual;
                this.atual = this.atual.next;
            }
        }while(!encontraPosicao);
    }
    public boolean isEmpty(){
        if (this.head == null) {
            return true;
        } else {
            return false;
        }
    }
}
