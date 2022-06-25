const requestOrigin = 'http://127.0.0.1:8080/produto';

new Vue({
    el: '#app',
    vuetify: new Vuetify(),
    data: {
        drawer: false,
        dialog: false,
        form: false,
        dialogDelete: false,
        snackbar: {
            message: '',
            visible: false,
            timeout: 4000
        },
        about: {
            visible: false,
            title: 'Sobre',
            goal: 'Este projeto tem por objetivo revisar e avaliar os conhecimentos absorvidos\
                até o momento atual do curso de Java Web e também servir como motivação para o\
                projeto final do curso.',
            teachers: [
                { name: 'Herysson Figueiredo', href: 'https://github.com/Herysson' },
                { name: 'Lucas Schlestein', href: 'https://github.com/lschlestein' },
                { name: 'Deivison Morim Pasa', href: 'https://github.com/dmpasa' }
            ],
            techs: [
                { name: 'Java Servlet', href: 'https://javaee.github.io/servlet-spec/' },
                { name: 'Apache Tomcat', href: 'https://tomcat.apache.org/' },
                { name: 'Apache Maven', href: 'https://maven.apache.org/' },
                { name: 'Eclipse Persistence', href: 'https://www.eclipse.org/eclipselink/' },
                { name: 'Google GSON', href: 'https://github.com/google/gson' },
                { name: 'JSON', href: 'https://www.json.org/json-en.html' },
                { name: 'Fetch API', href: 'https://developer.mozilla.org/pt-BR/docs/Web/API/Fetch_API' },
                { name: 'Vue.js', href: 'https://vuejs.org/' },
                { name: 'Material Design', href: 'https://material.io/design' },
                { name: 'Vuetify', href: 'https://vuetifyjs.com/en/' }
            ],
            devs: [
                { name: 'Gustavo Andretto', href: 'https://github.com/gustavoandretto' },
                { name: 'Eduardo Buchhorn', href: '#' }
            ]
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
            code: [
                v => parseInt(v) > 0 || 'Código inválido'
            ],
            quantity: [
                v => String(v).length > 0 || 'Campo obrigatório'
            ],
            value: [
                v => String(v).length > 0 || 'Campo obrigatório',
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
        noDataLoaded: true,
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
            this.noDataLoaded = true;

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

                    this.noDataLoaded = false;
                });
        },

        foo() {
            console.log("hello");
        },

        insertProduct(obj) {
            fetch(requestOrigin, {
                method: 'POST',
                body: JSON.stringify(obj)
            })
                .then(response => response.json())
                .then(data => {
                    if (data['success'] == true) {
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
                    if (data['success'] == true) {
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
                    if (data['success'] == true) {
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
            else if (id == 1) {
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
            this.editedItem.value = 0;
            this.editedItem.quantity = 0;
            this.editedItem.name = '';
            this.editedItem.code = 0;
            this.editedItem.category = '';
            this.resetValidation();
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

            this.reset();
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