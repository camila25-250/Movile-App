import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import LoginScreen from './src/screens/LoginScreen';
import HomeScreen from './src/screens/HomeScreen';
import UserScreen from './src/screens/UsersScreen';
import CategoriesScreen from './src/screens/CategoriesScreen';
import SubcategoriesScreen from './src/screens/SubcategoriesScreen';
import ProductsScreen from './src/screens/ProductsScreen';
import UsersScreen from './src/screens/UsersScreen';

const Stack = createNativeStackNavigator();
export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Login">
        <Stack.Screen
        name= "Login"
        component={LoginScreen}
        options={{ headerShown: false}}
        />
        <Stack.Screen
        name= "Home"
        component={HomeScreen}
        options={{ title: 'Menu Principal'}}
        />
        <Stack.Screen
        name= "Users"
        component={UsersScreen}
        options={{ title: 'Gestión de Usuarios'}}
        />
        <Stack.Screen
        name= "Categories"
        component={CategoriesScreen}
        options={{ title: 'Categorías'}}
        />
        <Stack.Screen
        name= "Subcategories"
        component={SubcategoriesScreen}
        options={{ title: 'Subcategorías'}}
        />
        <Stack.Screen
        name= "Products"
        component={ProductsScreen}
        options={{ title: 'Productos'}}
        />
      </Stack.Navigator>
      </NavigationContainer>
  );
}

