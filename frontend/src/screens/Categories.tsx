import React,{ useState, useEffect } from 'react';
import {View, Text, FlatList, TouchableOpacity, Alert, TextInput, Modal, ActivityIndicator, ScrollView} from 'react-native';
import { categoriesStyles } from '../styles/CategoriesStyles';
import { categoryService, authService } from '../services/api';

export default function CategoriesScreen() {
    const [categories, setCategories] = useState<any[]>([]);
    const [loading, setloading] = useState(false);
    const [modalVisible, setModalVisible] = useState(false);
    const [editing, setEditing] = useState<any>(null);
    const [formData, setFormData] = useState({ name: '', description: '' });
    const [error, setError] = useState('');
    const [currentUser, setCurrentUser] = useState<any>(null);

    useEffect(() => {
        loadCurrentUser();
        loadCategories();
    }, []);

    const loadCurrentUser = async () => {
        try{
            const user = await authService.getCurrentUser();
            setCurrentUser(user);
        } catch (error) {
            console.error('Error al cargar usuario: ', error);
        }
    };

    const loadCategories = async () => {
        setloading(true);
        setError('');
        try{
            const response = await categoryService.getAll();
            setCategories(response?. data || []);
        }catch (error) {
            setError('No se pudieron cargar las categorias.');
            setCategories([]);
        }finally {
            setloading(false);
        }
    };

    
    const handlesave = async () => {
        if (!formData.name.trim()) {
            Alert.alert('Error', 'El nombre es obligatorio');
            return;
        }

        try{
            if (editing){
                await categoryService.update(editing.id, formData);
                Alert.alert('Exito', 'Categoria actualizada');
            }
            else {
                await categoryService.create(formData);
                Alert.alert('Exito', 'Categoria creada');
            }
            setModalVisible(false);
            resetForm();
            loadCategories();
        }catch (error) {
            Alert.alert('Error', 'No se pudo guardar');
        }
    };

    const handleDelete = (item: any) => {
        if (currentUser?.role !== 'ADMIN'){
            Alert.alert('Acceso denengado', 'Solo los administradores pueden eliminar');
            return;
        }
        Alert.alert('Confirmar', `¿Eliminar ${item.name}?`),[
            {text: "Cancelar", style: "cancel"},
            {
                text: 'Eliminar',
                style: 'destructive',
                onPress: async () => {
                    try{

                    }
                }
            }
        ]
    }
}