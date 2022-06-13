const requestOrigin = 'http://127.0.0.1:8080/produto';

new Vue({
    el: '#app',
    vuetify: new Vuetify(),
    data: {  
        drawer: false,
        dialog: false,
        about: false,
        form: false,
        dialogDelete: false,
        snackbar: {
            message: '',
            visible: false,
            timeout: 4000
        },
        select: {
            category: [
                'Eletrodoméstico',
                'Informática',
                'Móveis e Decoração',
                'Eletroportáteis',
                'Casa e Construção',
                'Esporte',
                'Automotivo',
                'Papelaria',
                'Outros'
            ]
        },
        rule: {
            name: [
                v => !!v || 'Campo obrigatório',
            ],
            quantity: [
                v => String(v).length > 0 || 'Informe um valor',
            ],
            value: [
                v => String(v).length > 0 || 'Informe um valor',
            ]
        },
        route: {
            home: true,
            products: false
        },
        breadcrumbs: [
            { text: 'Home', disabled: false, id: 0, href: '#' },
            { text: 'Produtos', disabled: true, id: 1, href: '#' },
        ],
        table: {
            title: 'Lista de Produtos',
            headers: [
                { text: 'Código', value: 'code', align: 'start' },
                { text: 'Nome', value: 'name' },
                { text: 'Categoria', value: 'category' },
                { text: 'Quantidade', value: 'quantity' },
                { text: 'Valor (R$)', value: 'value' },
                { text: 'Ação', value: 'actions', sortable: false },
            ],
            pageIndex: 1,
            pageCount: 0,
            itemsPerPage: 10,
        },
        search: '',
        products: [],
        editedIndex: -1,
        editedItem: {
            code: 0,
            name: '',
            category: '',
            quantity: 0,
            value: 0
        },
        defaultItem: {
            code: 0,
            name: '',
            category: '',
            quantity: 0,
            value: 0
        }
    },
    computed: {
        formTitle() {
            return this.editedIndex === -1 ? 'Novo Produto' : 'Alterar Produto'
        },
    },

    watch: {
        dialog(val) {
            val || this.close();
        },
        dialogDelete(val) {
            val || this.closeDelete();
        },
    },

    created() {
        this.initialize();
    },

    methods: {
        initialize() {
        },

        loadProducts() {
            fetch(requestOrigin, {
                method: 'GET'
            })
            .then(res => res.json())
            .then(jsonObj => {
                this.products = [];

                for (var i = 0; i < Object.keys(jsonObj).length; i++) {
                    var objProd = {};
                    objProd.code = jsonObj[i]['codigo'];
                    objProd.name = jsonObj[i]['nome'];
                    objProd.category = jsonObj[i]['categoria'];
                    objProd.quantity = jsonObj[i]['quantidade'];
                    objProd.value = jsonObj[i]['valor'];
                    this.products.push(objProd);
                }
            });
        },

        insertProduct(obj) {
            fetch(requestOrigin, {
                method: 'POST',
                body: JSON.stringify(obj)
            })
            .then(response => response.json())
            .then(data => {
                if(data['success'] == true) {
                    this.snackbarMessage('Produto inserido com sucesso!');
                    this.loadProducts();
                }
                else {
                    this.snackbarMessage('Ocorreu um erro ao inserir o produto');
                    console.log(data['error']);
                }
            });
        },

        updateProduct(obj) {
            fetch(requestOrigin, {
                method: 'PUT',
                body: JSON.stringify(obj)
            })
            .then(response => response.json())
            .then(data => {
                if(data['success'] == true) {
                    this.snackbarMessage('Produto alterado com sucesso!');
                    this.loadProducts();
                }
                else {
                    this.snackbarMessage('Ocorreu um erro ao alterar o produto, verifique o console para mais detalhes');
                    console.log(data['error']);
                }
            });
        },

        deleteProduct(obj) {
            fetch(requestOrigin, {
                method: 'DELETE',
                body: JSON.stringify(obj)
            })
            .then(response => response.json())
            .then(data => {
                if(data['success'] == true) {
                    this.snackbarMessage('Produto excluído com sucesso!');
                    this.loadProducts();
                }
                else {
                    this.snackbarMessage('Ocorreu um erro ao excluir o produto');
                    console.log(data['error']);
                }
            });
        },

        routing(id) {
            if (id == 0) {
                this.route.home = true;
                this.route.products = false;
                this.drawer = false;
            }

            if (id == 1) {
                this.route.products = true;
                this.route.home = false;
                this.drawer = false;
                this.loadProducts();
            }
        },

        editItem(item) {
            this.editedIndex = this.products.indexOf(item);
            this.editedItem = Object.assign({}, item);
            this.dialog = true;
        },

        deleteItem(item) {
            this.editedIndex = this.products.indexOf(item);
            this.editedItem = Object.assign({}, item);
            this.dialogDelete = true;
        },

        snackbarMessage(msg) {
            this.snackbar.message = msg;
            this.snackbar.visible = true;
        },

        deleteItemConfirm() {
            this.deleteProduct(this.normalizeObject(this.editedItem));
            this.closeDelete();
        },

        validate() {
            return this.$refs.form.validate();
        },

        reset() {
            this.$refs.form.reset();
        },

        resetValidation() {
            this.$refs.form.resetValidation();
        },

        close() {
            this.dialog = false;
            this.$nextTick(() => {
                this.editedItem = Object.assign({}, this.defaultItem);
                this.editedIndex = -1;
            })
        },

        closeDelete() {
            this.dialogDelete = false;
            this.$nextTick(() => {
                this.editedItem = Object.assign({}, this.defaultItem);
                this.editedIndex = -1;
            })
        },

        normalizeObject(obj) {
            return {
                codigo: obj.code,
                nome: obj.name,
                categoria: obj.category,
                quantidade: obj.quantity,
                valor: obj.value
            };
        },

        save() {
            if (this.validate()) {
                if (this.editedIndex > -1) {
                    this.updateProduct(this.normalizeObject(this.editedItem));
                } else {
                    this.insertProduct(this.normalizeObject(this.editedItem));
                }

                this.close();
            }
        },
    }
})