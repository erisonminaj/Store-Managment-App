import {Component, OnInit} from "@angular/core";
import {User} from "./User";
import {UserService} from "./user.service";

@Component({
  selector: 'app-root',
  standalone: false,
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent implements OnInit {
  public users: User[] = [];

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {

    this.userService.getUsers().subscribe(
      (data: User[]) => {
        this.users = data;
      },
      (error) => {
        console.error('Error fetching user data:', error);
      }
    );
  }

  createUser() {

  }

  searchUser() {

  }
}
