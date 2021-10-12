import {Post} from "./post";

export class Person {
  id: string;
  lastName: string;
  firstName: string;
  patronymic: string;
  post: Post;
  birthDay: string;
  phone: string;

  constructor(id: string, lastName: string, firstName: string, patronymic: string, post: Post, birthDay: string, phone: string) {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
    this.patronymic = patronymic;
    this.post = post;
    this.birthDay = birthDay;
    this.phone = phone;
  }
}
