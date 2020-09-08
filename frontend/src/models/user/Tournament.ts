import User from '@/models/user/User';
import Topic from '@/models/management/Topic';
import { ISOtoString } from '@/services/ConvertDateService';

export default class Tournament {
  id!: number;
  startTime!: string;
  endTime!: string;
  numberOfQuestions!: number;
  canceled!: boolean;
  courseAcronym!: string;
  enrolled!: boolean;
  topics!: String[];
  topicsDto!: Topic[];
  participants!: User[];
  quizId!: number;
  privateTournament!: boolean;
  password!: string;

  constructor(jsonObj?: Tournament, user?: User) {
    if (jsonObj) {
      this.id = jsonObj.id;
      this.startTime = ISOtoString(jsonObj.startTime);
      this.endTime = ISOtoString(jsonObj.endTime);
      this.numberOfQuestions = jsonObj.numberOfQuestions;
      this.canceled = jsonObj.canceled;
      this.courseAcronym = jsonObj.courseAcronym;
      this.topics = [];

      if (jsonObj.topicsDto) {
        jsonObj.topicsDto.forEach((topic: Topic) => {
          if (!this.topics!.includes(topic.name)) {
            this.topics!.push(topic.name);
          }
        });
      }

      this.participants = jsonObj.participants;
      this.quizId = jsonObj.quizId;
      this.privateTournament = jsonObj.privateTournament;
      this.password = jsonObj.password;

      this.enrolled = false;
      if (user) {
        this.participants.forEach(pUser => {
          if (pUser.id == user.id) {
            this.enrolled = true;
            return;
          }
        });
        for (let i = 0; i < this.participants.length; i++) {
          if (user.id == this.participants[i].id) {
            this.enrolled = true;
            return;
          }
        }
      }
    }
  }

  static sortById(a: Tournament, b: Tournament) {
    if (a.id && b.id) return a.id > b.id ? 1 : -1;
    else return 0;
  }

  getStateColor(closedTournamentsId: number[]) {
    if (this.id && closedTournamentsId.includes(this.id)) return 'orange';
    else if (!this.canceled) return 'green';
    else return 'red';
  }

  getStateName(closedTournamentsId: number[]) {
    if (this.id && closedTournamentsId.includes(this.id)) return 'FINISHED';
    else if (!this.canceled) return 'AVAILABLE';
    else return 'CANCELLED';
  }

  getEnrolledColor() {
    if (this.enrolled) return 'green';
    else return 'red';
  }

  getEnrolledName() {
    if (this.enrolled) return 'YOU ARE IN';
    else return 'YOU NEED TO JOIN';
  }

  getPrivateColor() {
    if (this.privateTournament) return 'red';
    else return 'green';
  }

  getPrivateName() {
    if (this.privateTournament) return 'PRIVATE';
    else return 'PUBLIC';
  }

  isNotEnrolled() {
    return !this.enrolled;
  }

  isNotCanceled() {
    return !this.canceled;
  }

  isPrivate() {
    return this.privateTournament;
  }

  isClosed(closedTournamentsId: number[]) {
    return closedTournamentsId.includes(this.id);
  }
}
